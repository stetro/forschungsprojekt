'use strict';

var todoApplication = angular.module('todoApplication', ['ngResource']);

todoApplication.controller('todoController', function ($scope, $resource) {

    var localTodos = $resource('/todo/local/:id', {id: '@created'}, {
        update: {method: 'PUT'}
    });
    var rdfTodos = $resource('/todo/rdf/:id', {id: '@created'}, {
        update: {method: 'PUT'}
    });
    var Todos = localTodos;

    $scope.newTodo = '';
    $scope.todos = Todos.query();

    $scope.saveTodo = function () {
        var todo = new Todos({
            text: $scope.newTodo,
            done: false
        });
        todo.$save(function () {
            $scope.todos = Todos.query();
            $scope.newTodo = '';
        });
    };

    $scope.updateTodo = function (todo) {
        todo.done = !todo.done;
        todo.$update(function () {
            $scope.todos = Todos.query();
        });
    };

    $scope.deleteTodo = function (todo) {
        todo.$delete(function () {
            $scope.todos = Todos.query();
        });
    };
});
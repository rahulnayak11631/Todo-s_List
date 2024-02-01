$(document).ready(function() {
    function loadTodos() {
        $.get('/todos', function(todos) {
            $('#todoList').empty();
            todos.forEach(function(todo) {
                $('#todoList').append('<div class="todo-item">' + todo.task + 
                    '<button class="btn btn-danger btn-sm float-right delete-btn" data-id="' + todo.id + '">Delete</button>' +
                    '<button class="btn btn-success btn-sm float-right mr-2 update-btn" data-id="' + todo.id + '">Update</button>' +
                    '</div>');
            });
        });
    }

    loadTodos();

    $('#addTodo').click(function() {
        var todoInput = $('#todoInput').val();
        $.post('/add_todos', { task: todoInput }, function(data) {
            loadTodos();
            $('#todoInput').val('');
        });
    });

    $('#todoList').on('click', '.delete-btn', function() {
        var id = $(this).data('id');
        $.ajax({
            url: '/delete_todo/' + id,
            type: 'DELETE',
            success: function(result) {
                loadTodos();
            }
        });
    });

    $('#todoList').on('click', '.update-btn', function() {
        var id = $(this).data('id');
        var newTask = prompt("Enter new task");
        if(newTask) {
            $.ajax({
                url: '/update_todo/' + id,
                type: 'PUT',
                data: { task: newTask },
                success: function(result) {
                    loadTodos();
                }
            });
        }
    });
});

document.addEventListener("DOMContentLoaded", function() {
    fetchTodos();
});

function fetchTodos() {
    fetch('http://localhost:8080/todo') // Подставьте ваш URL для получения задач
        .then(response => response.json())
        .then(todos => {
            const list = document.getElementById("todoList");
            list.innerHTML = "";
            todos.forEach(todo => {
                const item = document.createElement("div");
                item.innerText = `${todo.title}: ${todo.description}`;
                list.appendChild(item);
            });
        });
}

function createTodo() {
    const title = document.getElementById("newTodoTitle").value;
    const description = document.getElementById("newTodoDescription").value;

    fetch('http://localhost:8080/todo', { // Подставьте ваш URL для создания задач
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            description: description,
            completeUntil: "2023-12-31T23:59:59Z" // Дата на ваше усмотрение
        })
    }).then(() => {
        fetchTodos(); // Обновить список задач после создания новой
    });
}

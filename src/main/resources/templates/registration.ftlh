<!doctype html>
<html lang="en">
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../static/loginstyle.css">
</head>
<body>
<div class="modal-dialog text-center">
    <div class="col-sm-8 main-section">
        <div class="modal-content">
            <div class="col-12 user-img">
                <img src="../img/avatar.png" alt="">
            </div>
            <form class="col-12" action="/registration" method="post">
                <div class="form-group">
                    <input type="text"
                           class="form-control"
                           placeholder="Введите логин"
                           name="username"
                    >
                </div>
                <div class="form-group">
                    <input class="form-control"
                           placeholder="Введите пароль"
                           type="password"
                           name="password"
                    >
                </div>
                <button type="submit" class="btn btn-primary" id="button">
                    Зарегистрироваться
                </button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
            <div class="col-12 new-user">
                <a href="/login">Уже есть аккаунт?</a>
            </div>
        </div>
    </div>
    <input type="hidden" id="alert" class="${warning!}">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        var input = document.getElementById("alert");
        document.addEventListener("DOMContentLoaded", function () {
            if (input.classList.contains("warning")) {
                swal("Упс!", "Юзер с таким логином уже существует.", "warning");
            }
        });
    </script>
</div>
</body>
</html>

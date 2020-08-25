<!doctype html>
<html lang="en">
<head>
    <title>Логин</title>
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
            <form class="col-12" action="/login" method="post">
                <div class="form-group">
                    <input class="form-control"
                           name="username"
                           placeholder="Введите логин"
                           type="text"
                    >
                </div>
                <div class="form-group">
                    <input class="form-control"
                           placeholder="Введите пароль"
                           type="password"
                           name="password"
                    >
                </div>
                <button type="submit" class="btn btn-primary">
                    Зайти
                </button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
            <div class="col-12 new-user">
                <a href="/registration">Создать аккаунт</a>
            </div>
        </div>
    </div>
    <input type="hidden" id="alert" class="${ok!}">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        var input = document.getElementById("alert");
        document.addEventListener("DOMContentLoaded", function () {
            if (input.classList.contains("ok")) {
                swal("Поздравляю!", "Вы успешно зарегистрированы.", "success");
            }
        });
    </script>
</div>
</body>
</html>

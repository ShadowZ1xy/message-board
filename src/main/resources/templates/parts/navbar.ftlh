<#include "session.ftlh">

<#macro header activeTab>

    <#switch activeTab>
        <#case "home">
            <#assign activeHome = "active">
            <#break>
        <#case "board">
            <#assign activeBoard = "active">
            <#break>
        <#case "user">
            <#assign activeUser = "active">
            <#break>
    </#switch>

    <#switch isAdmin>
        <#case false>
            <#assign showAdminPanel = "d-none">
            <#break>
        <#case true>
            <#assign showAdminPanel = "">
            <#break>
    </#switch>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" id="app-name" href="/">Message board</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ${activeHome!}">
                    <a class="nav-link" href="/">Главная страница</a>
                </li>
                <li class="nav-item ${activeBoard!}">
                    <a class="nav-link" href="/board">Стена сообщений</a>
                </li>
                <li class="nav-item ${activeUser!} ${showAdminPanel}">
                    <a class="nav-link" href="/user">Панель пользователей</a>
                </li>
            </ul>

            <#if name=" ">
                <a class="btn btn-success my-2 my-sm-0 login-button" type="Button" href="/login">Войти</a>
                <a class="btn btn-info my-2 my-sm-0" type="Button" href="/registration">Регистрация</a>
            <#else>
                <a type="button" class="btn btn-outline-secondary navbar-username" href="/profile">Никнейм: ${name}</a>
                <a class="btn btn-danger my-2 my-sm-0" type="Button" href="/logout">Выйти</a>
            </#if>

        </div>
    </nav>
</#macro>

<#macro header activeTab>

    <#switch activeTab>
        <#case "home">
            <#assign activeHome = "active">
            <#break>
        <#case "board">
            <#assign activeBoard = "active">
            <#break>
        <#case "profile">
            <#assign activeProfile = "active">
            <#break>
    </#switch>



    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Message board</a>
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
                <li class="nav-item ${activeProfile!}">
                    <a class="nav-link" href="/profile">Профиль</a>
                </li>
            </ul>
        </div>
    </nav>
</#macro>
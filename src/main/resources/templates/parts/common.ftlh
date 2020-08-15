<#import "navbar.ftlh" as navbar>

<#macro page title activeTab>
    <!doctype html>
    <html lang="en">
    <head>
        <title>${title}</title>
        <link rel="stylesheet" href="../../static/bootstrap.min.css">
        <link rel="stylesheet" href="../../static/style.css">
    </head>
    <body>
    <@navbar.header activeTab=activeTab></@navbar.header>

    <#nested>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </body>
    </html>
</#macro>

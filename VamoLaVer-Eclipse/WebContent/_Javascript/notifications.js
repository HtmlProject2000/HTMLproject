// A FUNÇÃO GetQueryString()
// encontra-se em https://pt.stackoverflow.com/questions/424/como-fa%C3%A7o-para-ler-valores-da-url-em-javascript-querystring

function getQueryString(a) {
    a = a || window.location.search.substr(1).split('&').concat(window.location.hash.substr(1).split("&"));

    if (typeof a === "string")
        a = a.split("#").join("&").split("&");

    // se não há valores, retorna um objeto vazio
    if (!a) return {};

    var b = {};
    for (var i = 0; i < a.length; ++i)
    {
        // obtem array com chave/valor
        var p = a[i].split('=');

        // se não houver valor, ignora o parametro
        if (p.length != 2) continue;

        // adiciona a propriedade chave ao objeto de retorno
        // com o valor decodificado, substituindo `+` por ` `
        // para aceitar URLs codificadas com `+` ao invés de `%20`
        b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
    }
    // retorna o objeto criado
    return b;
}

function scanner(){
    var notification = getQueryString();
    switch (notification["n"]){
        case "1"://usuário já logado
            alert("Você já está logado!!")
            break;
        case "2"://logado com sucesso
            alert("Bem vindo "+notification["nome"]+"!!!")
            break;
        case "3":
            alert("Um dos campos está incorreto!");
            break;
        case "4":
            alert("ação negada!!!");
            break;
    }
}
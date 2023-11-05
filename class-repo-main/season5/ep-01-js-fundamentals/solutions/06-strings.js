/**
 * Reduce duplicate characters to a desired minimum
 * wtf. Portanto vai verificar e remover, sobre uma string, os caracteres repetidos & SEGUIDOS até à quantidade amount
 * Se eu lhe passar (maaar, 2), deve retornar "maar".
 */
exports.reduceString = function(str, amount) {

    var count = 0;
    var reduced = '';

    str.split('').reduce(function(prev, cur) {

        count = (prev === cur ? count + 1 : 1);

        if (prev !== cur || count <= amount) {
            reduced += cur;
        }

        return cur;

    }, null);

    return reduced;
};

/**
 * Wrap lines at a given number of columns without breaking words
 * Que maneira estranha de explicar isto. Que diabo quer dizer com columns?
 * Portanto, o número de colunas é fundamentalmente o número de caracteres máximo até passar de linha
 * mas sem quebrar palavras inteiras. Portanto, em vez de cols chamar-lhe maxChars?
 * Wtf...
 */
exports.wordWrap = function(str, cols) {

    var wrap = false;
    var index = 0; // 1

    // portanto, parte a string num array de chars
    return str.split('').map(function (char) {

        if (!wrap) {
            // pra cada char, se wrap for false
            // verificamos se o index actual + 1 é divisor de cols
            // e se sim, wrap passa a true.
            // index + 1 % 4
            wrap = ((index + 1) % cols === 0 ? true : false);
        }

        // index incrementa
        index++;

        // se wrap estiver a true e o char for um espaço vazio
        // o wrap passa a false e o index passa a 0. E retornamos um \n
        if (wrap && char === ' ') {
            wrap = false;
            index = 0;
            return '\n';
        }

        // no final retorna sempre o char
        return char;

        // finalmente, já depois do map todo, faz um join de todos os caracteres novamente into a string.
    }).join('');
};

const ipsum = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";

let result = exports.wordWrap(ipsum, 50);
console.log(result);

/**
 * Reverse a String
 */
exports.reverseString = function(str) {

    return str.split('').reverse().join('');
};

exports.palindrome = function(str) {

    // return str === exports.reverseString(str);

    var end = str.length - 1;

    if (str.length <= 1) {
        return true;
    }

    if (str.charAt(0) !== str.charAt(end)) {
        return false;
    }

    return exports.palindrome(str.substr(1, str.length - 2));

};

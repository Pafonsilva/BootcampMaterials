/**
 * Create a developer person object with a code method
 * that delegates to the provided person object
 */
exports.createDelegate = function(person) {

    var devPerson = Object.create(person);
    devPerson.code = function() {
        return this.name + 'is coding';
    };

    return devPerson;
};

/**
 * Borrow and invoke the person say method on top of the company object
 */
exports.borrowSayMethod = function(person, company) {
    return person.say.call(company);
};

/**
 * Iterate over all of the provided object own properties,
 * returning an array of key: value strings
 */
exports.iterate = function(obj) {

    var result = [];

    Object.keys(obj).forEach(function(key) {
        result.push(key + ': ' + obj[key]);
    });

    return result;
};

/**
 * Add a repeatify method to all JavaScript Strings
 * 'string'.repeatify(3) should equal 'stringstringstring'
 * NOTE: This exercise exists for a pedagogic purpose only,
 * do not think doing stuff like this is a good idea...
 *
 * String already contains a repeat method, let's NOT use that one.
 */
exports.extendString = function() {

    // Functional Style
    String.prototype.repeatify = String.prototype.repeatify || function(num) {
        return (new Array(num)).fill(this).reduce((acc, cur) => acc + cur);
    }

    // Iterative Style
    // String.prototype.repeatify = String.prototype.repeatify || function(times) {

    //     var str = '';
    //     while (times > 0) {
    //         str += this;
    //         times--;
    //     }

    //     return str;
    // };
};

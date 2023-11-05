/**
 * Return an object with a login property,
 * accessible only through a getter and setter
 */
exports.buildLogin = function() {
    return {
        _login: '',
        get login() {
            return _login;
        },
        set login(handle) {
            _login = handle;
        }
    };
};

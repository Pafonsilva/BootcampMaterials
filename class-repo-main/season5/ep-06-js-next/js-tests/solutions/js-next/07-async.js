/**
 * Create an async retrieve method that fetches a user from an api url
 * using the global fetch(url) method. Proper error handling should be done
 * in case fetch does not return a user
 */
exports.User = class {

    constructor(url) {
        this.url = url;
    }

    async retrieve() {

        const user = await fetch(this.url);

        if (!user) {
            throw Error('user not found');
        }

        return user;
    }
};

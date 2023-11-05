let expect = require('expect.js');
var sinon = require('sinon');
let asyncAnswers = require('../../src/js-next/07-async');

describe('async/await', () => {

    before(() => {
        global.fetch = function() { };
    });

    after(() => {
        delete global.fetch;
    });

    it('you should be able to use async/await for performing async operations', (done) => {

        let requests = 0;
        const url = 'https://api.github.com/user';
        const login = 'ferrao';

        let fakeFetch = sinon.stub(global, 'fetch');
        fakeFetch.withArgs(url).callsFake(function() {
            return Promise.resolve({
                name: login
            });
        });
        fakeFetch.returns(undefined);

        expect(asyncAnswers.User.toString().includes('function')).to.be(false);

        let user = new asyncAnswers.User(url);
        expect(user.url).to.equal(url);

        let result = user.retrieve();
        result.then(value => {
            if (value && value.name === login) {
                requests++;
            }
        });

        user.url = '';
        result = user.retrieve();

        expect(result).to.be.an('object');
        expect(result.catch).to.be.a('function');
        result.catch(err => {
            requests++;
            expect(err).to.be.an(Error);
            expect(requests).to.equal(2);
            done();
        });
    });
});

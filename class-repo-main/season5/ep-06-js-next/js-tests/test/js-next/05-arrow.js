let expect = require('expect.js');
let sinon = require('sinon');
let arrowAnswers = require('../../src/js-next/05-arrow');

describe('arrow functions', () => {

    var clock;

    beforeEach(function() {

        clock = sinon.useFakeTimers();
    });

    afterEach(function() {

        clock.restore();
    });

    it('you should be able to bound this to lexical scope', () => {

        const time = 1000;
        const years = 10;

        let person = arrowAnswers.getPerson(years, time);
        let age = person.age;
        person.growUp();

        clock.tick(time);
        expect(person.age).to.equal(age + years);

        person = arrowAnswers.getPerson(years + 10, time * 2);
        age = person.age;
        person.growUp();

        clock.tick(time * 2);
        expect(person.age).to.equal(age + years + 10);
    });

    it('you should be able to return the arguments as an array from inside an arrow function', () => {

        let argsAsArray = arrowAnswers.getArgsAsArray();

        expect(argsAsArray.toString().includes('function')).to.be(false);

        expect(argsAsArray(1, 2, 3)).to.eql([1, 2, 3]);
        expect(argsAsArray('a', 'b', 'c')).to.eql(['a', 'b', 'c']);
        expect(argsAsArray()).to.eql([]);
    });

    it('you should be able to bound a function to the lexical scope', () => {

        let multiplier = arrowAnswers.getMultiplier();
        let multiplierFunc = multiplier.getMultiplierFunc();

        expect(multiplierFunc.call({ factor: 3 }, 3)).to.equal(3);
        expect(multiplierFunc(3)).to.equal(3);

        multiplier.factor = 2;
        expect(multiplierFunc(3)).to.equal(6);

    });

    it('you should be able to bound to the lexical scope of an object created by a constructor function', () => {

        let prefixer = new arrowAnswers.Prefixer('hi');
        expect(prefixer.prefixArray(['Rui', 'Pedro'])).to.eql(['hiRui', 'hiPedro']);
        expect(prefixer.prefixArray(['a', 'b'])).to.eql(['hia', 'hib']);
    });
});

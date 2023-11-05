let expect = require('expect.js');
let classAnswers = require('../../src/js-next/06-class');

describe('classes', () => {

    it('you should be able to create a class with a constructor and a method', () => {

        expect(classAnswers.Prefixer.toString().includes('function')).to.be(false);

        let prefixer = new classAnswers.Prefixer('hi');
        expect(prefixer.prefixArray(['Rui', 'Pedro'])).to.eql(['hiRui', 'hiPedro']);
        expect(prefixer.prefixArray(['a', 'b'])).to.eql(['hia', 'hib']);
    });

    it('you should be able to sublcass an existing class', () => {

        expect(classAnswers.PrefixerSufixer.toString().includes('function')).to.be(false);
        expect(classAnswers.PrefixerSufixer.toString().includes('prefixArray')).to.be(false);
        expect(classAnswers.PrefixerSufixer.toString().includes('super')).to.be(true);

        let prefixerSufixer = new classAnswers.PrefixerSufixer('hi', 'bye');
        expect(prefixerSufixer.prefixArray(['Rui', 'Pedro'])).to.eql(['hiRui', 'hiPedro']);
        expect(prefixerSufixer.prefixArray(['a', 'b'])).to.eql(['hia', 'hib']);
        expect(prefixerSufixer.sufixArray(['Rui', 'Pedro'])).to.eql(['Ruibye', 'Pedrobye']);
        expect(prefixerSufixer.sufixArray(['a', 'b'])).to.eql(['abye', 'bbye']);
    });
});

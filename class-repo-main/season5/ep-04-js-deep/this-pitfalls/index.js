// get a collection of all button elements on the page
var buttons = document.getElementsByTagName('button');

// make sure every button on page is only pressed once
for (var i = 0; i < buttons.length; i++) {
    buttons[i].onclick = function() {
        console.log(this.innerText + ' was pressed!');
        disableButton.call(this);
    }
}

function disableButton() {
  this.disabled = true;
}
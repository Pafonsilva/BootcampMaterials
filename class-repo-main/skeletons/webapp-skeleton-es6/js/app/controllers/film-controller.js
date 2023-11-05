import { bind, render } from "./../views/film-view.js";
import getFilm from "./../services/film-service.js";

const bindEventHandlers = () => bind("button", buttonHandler);

const buttonHandler = () => {
    const filmIndex = Math.floor(Math.random() * 6);
    getFilm(filmIndex, (film) => render(film));
};

export const start = () => {
    bindEventHandlers();
    render();
};

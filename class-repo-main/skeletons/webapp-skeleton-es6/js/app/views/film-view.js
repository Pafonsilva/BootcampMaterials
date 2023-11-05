// the point of separating elements from their handlers is flexibility
const elements = {};
const handlers = {};

const createButton = () =>
    '<button class="random-film">Click Me for a Random Film</button>';

const createFilmCard = ({title, year, director, imdbRating}) =>
    `<div>
        <p><strong>Title: </strong>${title}</p>
        <p><strong>Year: </strong>${year}</p>
        <p><strong>Director: </strong>${director}</p>
        <p><strong>IMDB rating: </strong>${imdbRating}</p>
        </div>`;

const renderFilm = (film) => {
    if (elements.filmCard) {
        elements.filmCard.empty();
    }

    elements.filmCard = $(createFilmCard(film));
    elements.app.append(elements.filmCard);
};

const renderButton = () => {
    if (elements.button) {
        return;
    }

    elements.button = $(createButton());
    elements.button.click(handlers.button);
    elements.app.append(elements.button);
};

// We could also export a single object with these two...
export const bind = (event, handler) => (handlers[event] = handler);

export const render = (film) => {
    elements.app = $("#app");
    renderButton();

    if (film) {
        renderFilm(film);
    };
};

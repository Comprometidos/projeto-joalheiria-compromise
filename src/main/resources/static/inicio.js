
let currentIndex = 0;

function moveCarousel(direction) {
    const container = document.querySelector('.card__container');
    const totalCards = document.querySelectorAll('.card__article').length;
    currentIndex = (currentIndex + direction + totalCards) % totalCards;
    const offset = -currentIndex * 340; // Ajuste a largura conforme necessário

    container.style.transform = `translateX(${offset}px)`;
}

let currentIndex = 0;

function moveCarousel(direction) {
  const container = document.querySelector('.card__container');
  const cards = document.querySelectorAll('.card__article');
  const cardWidth = cards[0].offsetWidth + 20; // 340px + margem
  const maxIndex = cards.length - Math.floor(container.parentElement.offsetWidth / cardWidth);

  currentIndex += direction;

  if (currentIndex < 0) currentIndex = 0;
  if (currentIndex > maxIndex) currentIndex = maxIndex;

  const offset = -currentIndex * cardWidth;
  container.style.transform = `translateX(${offset}px)`;
}
let currentIndex = 0;

document.getElementById('btnNext').addEventListener('click', () => {
  moveCarousel(1);
});

document.getElementById('btnPrev').addEventListener('click', () => {
  moveCarousel(-1);
});

function moveCarousel(direction) {
  const track = document.getElementById('carouselTrack');
  const cards = track.querySelectorAll('.card');
  const cardWidth = cards[0].offsetWidth + 20;
  const visibleCards = Math.floor(track.parentElement.offsetWidth / cardWidth);
  const maxIndex = cards.length - visibleCards;

  currentIndex += direction;
  currentIndex = Math.max(0, Math.min(currentIndex, maxIndex));

  const translateX = -currentIndex * cardWidth;
  track.style.transform = `translateX(${translateX}px)`;
}

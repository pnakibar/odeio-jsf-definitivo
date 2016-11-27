const stars = [1,2,3,4,5].map(
  n => document.getElementById(`star-${n}`)
);

$('.star').hover(
  function () {
    // hover in
    const numberOfStar = this.id.split('-').pop();
    stars.forEach((el, i) => {
      if (i < numberOfStar && !$(el).hasClass('star-clicked')) {
        $(el).addClass('star-hovered');
      }
    })
  },
  function () {
    stars.forEach(el =>
      $(el).removeClass('star-hovered')
    );
  }
);

$('.star').click(function() {
  stars.forEach(el =>
    $(el).removeClass('star-clicked')
  );
  const numberOfStar = this.id.split('-').pop();
  stars.forEach((el, i) => {
    if (i < numberOfStar) {
      $(el).addClass('star-clicked');
    }
  })
});

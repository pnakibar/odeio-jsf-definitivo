const listenToLike = (el) => {
  el.addEventListener('click', function () {
    const likesHTML = newNumberOfLikes => `${newNumberOfLikes} <i class="fa fa-thumbs-up" aria-hidden="true"></i>`
    if (!this.classList.contains('liked')) {
      const newNumberOfLikes = new Number(el.textContent) + 1;
      el.innerHTML = likesHTML(newNumberOfLikes);
      this.classList.add('liked');
    }
    else {
      const newNumberOfLikes = new Number(el.textContent) - 1;
      el.innerHTML = likesHTML(newNumberOfLikes);
      this.classList.remove('liked');
    }
  })
}

Array.from(
  document.getElementsByClassName('like-button')
).forEach(e => listenToLike(e));

const messageContainer = document.getElementById('message-container');

function appendHtml(el, str) {
  const div = document.createElement('section');
  div.innerHTML = str;
  while (div.children.length > 0) {
    el.insertBefore(div.children[0], messageContainer.firstChild);
  }
}


Array.from(
  document.getElementsByClassName('enviar-new-comment')
).forEach(e => {
  e.addEventListener('click', function () {
    const text = document.getElementById('new-comment').value;
    if (!text) return;
    const html = `<section>
      <div class="media msg">
        <a class="pull-left" href="#">
          <img class="media-object" data-src="holder.js/64x64" alt="64x64" style="width: 32px; height: 32px;" src="https://cdn1.iconfinder.com/data/icons/user-pictures/100/male3-512.png">
        </a>
        <div class="media-body">
          <h5 class="media-heading">
          @borgebeermaker
          <small class="time"><i class="fa fa-clock-o"></i><time> Agora mesmo</time></small>
        </h5>
          <small class="col-lg-10">${text}</small>
          <div class="col-lg-12 like-button">
            0 <i class="fa fa-thumbs-up" aria-hidden="true"></i>
          </div>
        </div>
      </div>
    </section>`;
    appendHtml(messageContainer, html); // "body" has two more children - h1 and span.
    listenToLike(Array.from(document.getElementsByClassName('like-button'))[0]);
    document.getElementById('new-comment').value = "";
  })
})

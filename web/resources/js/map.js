function initMap() {
  let center = {
    lat: 0,
    lng: 0,
  }
  let map = new google.maps.Map(document.getElementById('map'), {
    zoom: 4,
    center: center,
  })

  navigator.geolocation.getCurrentPosition(
    (position) => {
      const newCenter = {
        lat: position.coords.latitude,
        lng: position.coords.longitude
      }
      map.setCenter(newCenter);
    }
  );

  var gpsedPost = {
    lat: -23.533773,
    lng: -46.625290
  };
  let contentString = `<div class="media msg">
      <a class="pull-left" href="#">
        <img class="media-object" data-src="holder.js/64x64" alt="64x64" style="width: 32px; height: 32px;" src="https://cdn1.iconfinder.com/data/icons/user-pictures/100/female1-512.png">
      </a>
      <div class="media-body">
        <h5 class="media-heading">
          @marieta
          <small class="time"><i class="fa fa-clock-o"></i> 12:10am</small>
        </h5>
        <small class="col-lg-10">Vou colar hoje lá na @brewdogsp para tomar um Punk IPA, alguém anima?</small>
        <div class="col-lg-12">
          10 <i class="fa fa-thumbs-up" aria-hidden="true"></i>
        </div>
      </div>
    </div>`;
  let infoWindow = new google.maps.InfoWindow({
    content: contentString,
  })

  var marker = new google.maps.Marker({
    position: gpsedPost,
    map: map,
    title: '@marieta',
  });
  marker.addListener('click', () => infoWindow.open(map, marker));
};

<template>
  <div class="Showmovie">
    <div class="wrap">
      <ul class="movies">
        <li v-for="(movie, index) in movies" v-bind:key="index" class="item">
          <span class="rank">상영관 : {{ movie.theater_id }}</span>
          <div class="detail">
            <p class="time">상영시간 : {{ movie.play_time }}</p>
            <p class="tit">상영작 : {{ movie.movie_title }}</p>
            <p class="comment">전체 좌석 : {{ movie.all_seats }}</p>
            <p class="comment">남은 좌석 : {{ movie.all_seats - movie.counted }}</p>
            <!-- <div class="message">
              <p>{{ count }}</p>
              <button v-on:click.prevent="increment">+</button>
              <button v-on:click.prevent="decrement">-</button>
            </div> -->

            <!-- <li @click="clickParams">
              인원 확인
            </li> -->
            <router-link
              :to="{ name: 'seatmovie', params: { movie: movie, time: movie.play_time} }"
              class="link"
            >
              좌석 확인하러 가기
            </router-link>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
import MovieDataService from "../services/MovieDataService";

export default {
  created() {
    this.$axios
      .get(
        "http://localhost:8000/movie/showmovie/" + `${this.$route.params.id}` 
      )
      .then(res => {
        console.log("response>>>", res);
        console.log("id>>>",`${this.$route.params.id}`);
        this.movies = res.data;
      });
  },
  data() {
    return {
      id: "",
      movies: [],
      count: 0
    };
  },
  methods: {
    select: function(event, line, cell) {
      // this.targetId = event.currentTarget.id;
      if (event.target.id == "") {
        event.target.id = "select";
      } else {
        event.target.id = "";
      }

      console.log(line + " / " + cell);
    },
    test() {
      console.log(this.selectedline); // returns 'foo
      console.log(this.selectedcell);
    },
    // clickParams () {
    //     this.$router.push({name: 'seatmovie', params: { id: movie.play_time}})
    // }
  }
};
</script>

<style>
.li {
  border-style: double;
}

.item {
  display: inline-block;
  margin: 15px;
  border-style: double;
  background-color: rgb(247, 214, 203);
  width: 25%;
  font-size: 25px;
  font-weight: bold;
}
.seat {
  display: inline-block;
}
.seatitem {
  border-color: black;
  color: gray;
  padding: 5px;
  margin: 10px;
  border-style: solid;
}
#select.seatitem {
  background: #fdcf01;
}
</style>

<template>
  <div class="Movie">
    <div class="wrap">
      <h1>예약내역 조회</h1>
      <div class="homebox">        
        <p>핸드폰 번호를 입력하여 예매내역을 확인하세요</p> 
        <input
          type="text"
          id="name"
          name="name"
          required
          minlength="4"
          maxlength="16"
          size="16"
        />
        <button class="jo" @click="yemecheck">조회하기</button>
      </div>
      <ul class="movies">
        <li v-for="movie in movies" v-bind:key="movie.id" class="item">
          <span class="rank">상영작 : {{ movie.movie_title }}</span><br/>
          <span class="rank">상영관 : {{ movie.theater_id }}</span><br/>
          <span class="rank">상영시간 : {{ movie.play_time }}</span><br/>
          <span class="rank">좌석 : {{ String.fromCharCode(movie.row + 64) }}-{{ movie.col }}</span><br/>
        </li>
      </ul>
      <router-link :to="{name:'movie'}"><div class="home">홈으로 돌아가기</div></router-link>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
export default {
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      movies: []
    };
  },


/**
 * axios.get(url, {
    params: {
      ID: 12345
    }
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  })
  .then(function () {
    // always executed (try catch finally에서 finally부분)
});
 *
 */
  methods:{
    yemecheck() {[
        this.$axios.get("http://localhost:8000/reservation/checkres", {
            params: {
                phone:document.getElementById("name").value,
            }
        })
        .then(res => {
            console.log(res);
            this.movies = res.data
        })
    ]}
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
*,
*:before,
*:after {
  box-sizing: border-box;
}
body {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
body,
div,
dl,
dt,
dd,
ul,
ol,
li,
h1,
h2,
h3,
h4,
h5,
h6,
form,
fieldset,
p,
button,
table,
th,
td,
input {
  margin: 0;
  padding: 0;
}
input,
fieldset,
img,
iframe {
  border: 0;
}
ul,
ol {
  list-style-type: none;
}
a {
  color: inherit;
  text-decoration: none;
  outline: none;
  cursor: pointer;
}
a:hover,
a:focus {
  color: inherit;
  text-decoration: none;
}
.hidden {
  display: none !important;
}
button {
  border: none;
  background: none;
  cursor: pointer;
  outline: none;
}
button:disabled,
button:disabled:hover {
  cursor: default;
}

body {
  background: #000;
}
h1 {
  font-size : 30px;
  color: #000;
}
ul {
  overflow: hidden;
}
li {
  float: left;
  margin: 10px;
  width: calc(33% - 20px);
  background: #fff;
  text-align: center;
}

.poster {
  width: 100%;
  height: 400px;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
}

.album-info {
  padding: 10px;
}

.album-title {
  font-family: "Noto Sans KR", sans-serif;
}

.album-date {
  font-size: 12px;
}

.message {
  padding-bottom: 20px;
  font-weight: bold;
}

.homebox {
  border-style: solid;
  padding : 30px;
}

#name {
  border: solid 2px;
}

.jo {
  font-size: 20px;
  border-style: solid;
}

.home {
  font-size: 25px;
}
</style>

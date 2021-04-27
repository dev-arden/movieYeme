<template>
  <div class="Movie">
    <div class="wrap">
      <h1>상영 테이블</h1>
      <ul class="movies">
        <li v-for="movie in movies" v-bind:key="movie.id" class="item">
            <router-link :to="{ name: 'showmovie', params: { id: movie.movie_id } }" class="link">
            <!-- <img v-bind:src="movie.movie_poster" class="poster" /> -->
            <!-- <img v-bind:src="require(`@/assets/${movie.movie_poster}.jpg`)" /> -->
            <img v-bind:src="require(`@/assets/${movie.movie_poster}.jpg`)"  class="poster"/>
          </router-link>
          <div class="detail">
            <p class="tit">{{ movie.movie_title }}</p>
            <p class="comment">{{ movie.movie_comment }}</p><br />
            <router-link :to="{ name: 'showmovie', params: { id: movie.movie_id } }" class="go">
              예매하기
            </router-link>
          </div>
        </li>
      </ul>
      <router-link :to="{name: 'yemecheck'}"><div class="check">예약 조회하기</div></router-link>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
export default {
  created () {
    // 컴포넌트가 생성될 때, /api/movies에 요청을 보냅니다.          
    this.$axios.get("http://localhost:8000/movie/movies")
      .then(res => {
          console.log(res);
          this.movies = res.data
        });
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      movies: []
    };
  },
  methods:{

  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
*, *:before, *:after { box-sizing: border-box; }
body { -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale; }
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,form,fieldset,p,button,table,th,td,input {margin:0;padding:0;}
input, fieldset, img, iframe {border:0;}
ul,ol {list-style-type:none;}
a {color:inherit;text-decoration:none;outline: none;cursor:pointer; }
a:hover, a:focus {color:inherit;text-decoration:none;}
.hidden {display:none !important;}
button {border:none;background:none;cursor:pointer;outline:none;}
button:disabled, button:disabled:hover {cursor: default;}

body { background: #000; }
h1 { color: black; }
ul { overflow: hidden; }
li { float: left; margin: 10px; width: calc(33% - 20px); background: #fff; text-align: center; border-style: groove; }


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
  font-family: 'Noto Sans KR', sans-serif;
}

.album-date {
  font-size: 12px;
}

.tit {
  font-size: 20px;
  font-weight: bold;
}

.comment{
  background-color: cornsilk;
}

.go{
  border-style: dotted;
  font-size: 18px;
}

.check{
  font-size: 25px;
  border-style: groove;
  margin : 10px;
  margin-right: 15px;
}
.Movie{
  margin:20px;
}
</style>

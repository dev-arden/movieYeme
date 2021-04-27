<template>
  <div class="Seatmovie">
    <div class="checkPeople">
      <div class="message">
        <button v-on:click.prevent="increment">+</button>
        <p>상영 인원 : {{ count }}</p>
        <button v-on:click.prevent="decrement">-</button>
      </div>
      
    </div>
    <div class="wrap">
      <ul class="movies">
        <li class="board">
          <div v-if='movie.rows' class="chessboard">
            <div v-for="(line, index) in movie.rows" v-bind:key="index">
              <div
                v-for="(cell, index) in movie.cols"
                v-bind:key="index"
                class="seat">
                <!-- <button>{{cell}}</button> -->
                <!-- <div class="seatitem" @click="select($event, line, cell)">
                  {{ cell }}
                </div> -->
                <button class='seatitem' :disabled='check(line, cell)'
                  @click='select($event, line, cell)'>
                  {{String.fromCharCode(line + 64)}}-{{cell}}
                </button>
              </div>
            </div>
            <!-- <button class='link' @click='yeme'>예매하기</button> -->
          </div>
        </li>
        <br/>
        <router-link :to="{ name: 'yememovie', params: { movie: movie, people: count, seats: obj } }" class="link">
              예매하기
        </router-link>
      </ul>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
export default {
  props: ['movie', 'time'],
  created () {
    console.log(this.movie + "time:" + this.time),
    this.$axios
      .get(
        "http://localhost:8000/theater/getseats/", {
           params: {
                id: this.movie.theater_id,
                time:this.time
            }
        })
      .then(res => {
        console.log(res.data[0])
        this.movie = res.data[0]
        //console.log(this.movie.seats)
        this.movie.seats = JSON.parse(this.movie.seats)
        console.log(this.movie)
      });
  },
  data() {
    return {
      // id: "",
      count : 0,
      selectedSeats: 0,
      obj: {}
    };
  },
  methods: {
    check (row, column) { // 해당 좌석이 예매 가능한지 검사
      for (const seat of this.movie.seats) {
        if (seat.row == row && seat.column == column) {
          return true
        }
      }
      return false
    },
    select: function(event, line, cell) {
      // this.targetId = event.currentTarget.id;
      const key = line + '' + cell
      if (this.count > this.selectedSeats && event.target.id == "") {
        event.target.id = "select";
        this.obj[key] = {
          row: line,
          column: cell
        }
        this.selectedSeats++
      } else if (event.target.id === 'select') {
        event.target.id = "";
        delete this.obj[key]
        this.selectedSeats--
      }
      console.log(this.obj)
    },
    increment() {
      this.count++;
    },
    decrement() {
      if (this.count > 0) {
        this.count--;
      }
    }
  }
};
</script>

<style>
.board {
  display: inline-block;
  margin: 15px;
  border-style: solid;
  padding: 30px;
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
.message {
  padding-left: 100px;
  padding-right: 100px;
  padding-top: 20px;
  padding-bottom: 20px;
  font-weight: bold;
  display: inline-block;
  border-style: groove;
}
.seatitem:disabled {
  background: red;
}

.link {
  font-size: 30px;
}
</style>

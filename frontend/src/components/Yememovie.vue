<template>
  <div class="Yememovie">
    <h1>예매내역 확인</h1>
    <div class="box">     
      상영관 : {{movie.theater_id}}<br/>
      상영작 : {{movie.movie_title}}<br/>
      상영시간 : {{movie.play_time}}<br/>
      상영인원 : {{people}}<br/>
      <div v-for='(seat, index) in seats' :key='index'>
          선택좌석 : {{String.fromCharCode(seat.row + 64)}}-{{seat.column}}
      </div>
    </div>
    <br/>
    
    <div class="box2">  
      <p>예매정보가 맞다면 핸드폰 번호를 입력해 예매를 완료해주세요.</p>
      <input type="text" id="name" name="name" required minlength="4" maxlength="16" size="16">
      <router-link :to="{ name: 'movie'}"><button class="btn" @click="yeme">예매완료</button></router-link>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
let index=0;

export default {
  props: ['movie', 'people', 'seats'],
  data() {
    return {
      id: "",
      movies: [],
      count: 0,
      selectedSeats: 0,
      obj: {},
      row:0,
      col:0
    };
  },
  methods: {
    yeme() {
        //Object.keys(test)
        //obj[Object.keys(obj)[0]]
        this.count = this.people
        console.log(this.seats)
        this.$axios.post(" http://localhost:8000/reservation/insert/",null, {
                params: {
                    phone_number:document.getElementById("name").value,
                    movie_title:this.movie.movie_title,
                    ticket_count:this.people,
                    theater_id:this.movie.theater_id,
                    play_time:this.movie.play_time,
                    seats: JSON.stringify(this.seats)
                }
            }
        )
        .then(res => {
            alert('예매가 완료되었습니다!');
        });
    }
  }
};
</script>

<style>
.item {
  display: inline-block;
  margin: 15px;
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
  padding-bottom: 20px;
  font-weight: bold;
}

.box {
  border-style: solid;
  font-size: 30px;
  background-color: rgb(245, 225, 207);
  padding-top: 30px;
  padding-bottom: 30px;
}

.btn {
  font-size: 30px;
}

#name {
  font-size: 30px;
}

.box2 {
  border-style: solid;
  padding : 30px;
}
</style>

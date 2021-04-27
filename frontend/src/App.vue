<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import Movie from './components/Movie.vue'
import Skip from './components/Skip.vue'
import Clementain from './components/Clementain.vue'

export default {
  name: 'App',
  components: {
    Movie,
    Skip,
    Clementain
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

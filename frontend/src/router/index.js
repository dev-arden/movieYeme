import Vue from 'vue'
import Router from 'vue-router'
import Movie from '@/components/Movie'
import Skip from '@/components/Skip'
import Clementain from '@/components/Clementain'
import Showmovie from '@/components/Showmovie'
import Seatmovie from '@/components/Seatmovie'
import Yememovie from '@/components/Yememovie'
import Yemecheck from '@/components/Yemecheck'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'movie',
      component: Movie
    },
    {
      path: '/skip',
      name: 'skip',
      component: Skip
    },
    {
      path: '/clementain',
      name: 'clementain',
      component: Clementain
    },
    {
      path: '/showmovie',
      name: 'showmovie',
      component: Showmovie,
      props: true
    },
    {
      path: '/seatmovie',
      name: 'seatmovie',
      component: Seatmovie,
      props: true
    },
    {
      path: '/yememovie',
      name: 'yememovie',
      component: Yememovie,
      props: true
    },
    {
      path: '/yemecheck',
      name: 'yemecheck',
      component: Yemecheck,
      props: true
    },
  //   {
  //     path: '/params',
  //     component: Params,
  //     name: 'Params',
  //     // true로 설정하면 데이터를 props로도 받습니다.
  //     props: true
  // }     
  ]
})

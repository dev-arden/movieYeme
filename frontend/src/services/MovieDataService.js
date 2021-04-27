import http from '../http-common'

class MovieDataService {
  get(id) {
    return http.get(`/showmovie/${id}`);
  }
}

// export default {
//   name: "MovieDataService",
//   data() {
//     return {
//       message: ""
//     };
//   }
// };

export default new MovieDataService();

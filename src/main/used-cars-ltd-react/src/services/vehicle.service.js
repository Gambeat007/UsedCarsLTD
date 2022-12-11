import http from "../http-common";

class VehicleDataService {


  create(data) {
    return http.post("/vehicles/add-new", data);
  }

}

export default new VehicleDataService();
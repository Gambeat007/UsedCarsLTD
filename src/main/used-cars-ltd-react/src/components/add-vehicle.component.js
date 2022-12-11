import React, { Component } from "react";
import VehicleDataService from "../services/vehicle.service";

export default class AddVehicle extends Component {
  constructor(props) {
    super(props);
    this.onChangeMake = this.onChangeMake.bind(this);
    this.onChangeModel = this.onChangeModel.bind(this);
    this.onChangeProdYear = this.onChangeProdYear.bind(this);
    this.onChangePrice = this.onChangePrice.bind(this);
    this.onChangeFuelType = this.onChangeFuelType.bind(this);
    this.saveVehicle = this.saveVehicle.bind(this);
    this.newVehicle = this.newVehicle.bind(this);

    this.state = {
      id: null,
      make: "",
      model: "", 
      prodYear: "",
      price: "",
      fuelType: "",

      submitted: false
    };
  }

  onChangeMake(e) {
    this.setState({
      make: e.target.value
    });
  }

  onChangeModel(e) {
    this.setState({
      model: e.target.value
    });
  }

  onChangeProdYear(e) {
    this.setState({
      prodYear: e.target.value
    });
  }

  onChangePrice(e) {
    this.setState({
      price: e.target.value
    });
  }

  onChangeFuelType(e) {
    this.setState({
      fuelType: e.target.value
    });
  }

  saveVehicle() {
    var data = {
      make: this.state.make,
      model: this.state.model,
      prodYear: this.state.prodYear,
      price: this.state.price,
      fuelType: this.state.fuelType
    };

    VehicleDataService.create(data)
      .then(response => {
        this.setState({
          id: response.data.id,
          make: response.data.make,
          model: response.data.model,
          prodYear: response.data.prodYear,
          price: response.data.price,
          fuelType: response.data.fuelType,

          submitted: true
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  newVehicle() {
    this.setState({
      id: null,
      make: "",
      model: "", 
      prodYear: "",
      price: "",
      fuelType: "",
      
      submitted: false
    });
  }

  render() {
    return (
      <div className="submit-form">
        {this.state.submitted ? (
          <div>
            <h4>You submitted successfully!</h4>
            <button className="btn btn-success" onClick={this.newVehicle}>Add Vehicle</button>
          </div>
        ) : (
          <div>
            <div className="form-group">
              <label htmlFor="make">Make</label>
              <input type="text" className="form-control" id="make" name="make"
                required value={this.state.make}
                onChange={this.onChangeMake} />
            </div>

            <div className="form-group">
              <label htmlFor="model">Model</label>
              <input type="text" className="form-control" id="model" name="model"
                required value={this.state.model}
                onChange={this.onChangeModel} />
            </div>

            <div className="form-group">
              <label htmlFor="prodYear">Production year</label>
              <input type="text" className="form-control" id="prodYear" name="prodYear"
                required value={this.state.prodYear}
                onChange={this.onChangeProdYear} />
            </div>

            <div className="form-group">
              <label htmlFor="price">Price</label>
              <input type="text" className="form-control" id="price" name="price"
                required value={this.state.price}
                onChange={this.onChangePrice} />
            </div>

            <div className="form-group">
              <label htmlFor="fuelType">Fuel type</label>
              <input type="text" className="form-control" id="fuelType" name="fuelType"
                required value={this.state.fuelType}
                onChange={this.onChangeFuelType} />
            </div>

            <button onClick={this.saveVehicle} className="btn btn-success">Submit</button>
          </div>
        )}
      </div>
    );
  }
}
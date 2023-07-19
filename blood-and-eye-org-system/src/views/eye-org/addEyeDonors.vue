<template>
  <div class="container">
    <h1>Add Eye Donors</h1>
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      <strong>{{ alertMessage }}</strong>
    </div>
    <div class="row mb-4">
      <div class="col mt-5">
        <form @submit="addEyedonor($event)">
          <div class="form-group row mt-5">
            <label for="donarName" class="col-sm-5 col-form-label text-dark"
              >Enter Donor Name:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarName"
                v-model="EyeDonarClass.donorName"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarEmail" class="col-sm-5 col-form-label text-dark"
              >Donor Email:</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarEmail"
                v-model="EyeDonarClass.donorEmail"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarAge" class="col-sm-5 col-form-label text-dark"
              >Donor Age :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarAge"
                v-model="EyeDonarClass.donorAge"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarAddress" class="col-sm-5 col-form-label text-dark"
              >Donor Address :</label
            >
            <div class="col-sm-6">
              <input
                type="text"
                class="form-control"
                id="donarAddress"
                v-model="EyeDonarClass.donorAddress"
                required
              />
            </div>
          </div>

          <div class="form-group row mt-4">
            <label
              for="donarBloodType"
              class="col-sm-5 col-form-label text-dark"
              >Blood Type :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="EyeDonarClass.donorBloodType"
                id="donarBloodType"
              >
                <option selected>Select Blood Type</option>
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="AB+">AB+</option>
                <option value="AB-">AB-</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
              </select>
            </div>
          </div>

          <div class="form-group row mt-4">
            <label for="donarGender" class="col-sm-5 col-form-label text-dark"
              >Donor Gender :</label
            >
            <div class="col-sm-6">
              <select
                class="form-control"
                v-model="EyeDonarClass.donorGender"
                id="donarGender"
              >
                <option selected>Select Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
              </select>
            </div>
          </div>

          <button type="submit" class="btn btn-success mt-5">Add Donor</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import backendEyeRestApi from '@/service/backendEyeRestApi';
export default {
  name: "addEyeDonors",
  data() {
    return {
      EyeDonarClass: {
        donorName: "",
        donorEmail: "",
        donorAge: "",
        donorAddress: "",
        donorBloodType: "",
        donorGender: "",
      },
      showAlert: "",
      alertMessage: "",
    };
  },
  methods: {
    addEyedonor(event) {
      event.preventDefault();
      backendEyeRestApi
        .addEyeDonors(this.EyeDonarClass)
        .then((response) => {
          if (response.data) {
            this.showAlert = true;
            this.alertMessage = "Donor Added Successfully";
            setTimeout(() => {
              this.showAlert = false;
              this.alertMessage = "";
              this.EyeDonarClass = {
                donorName: "",
                donorEmail: "",
                donorAge: "",
                donorAddress: "",
                donorBloodType: "",
                donorGender: "",
              };
            }, 3000);
          }
        })
        .catch((error) => {
          this.showAlert = true;
          this.alertMessage = "Error adding donor: " + error.message;
        });
    },
  },
};
</script>

<style></style>

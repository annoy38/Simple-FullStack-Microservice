<template>
  <div class="container">
    <div v-if="showAlert" class="alert alert-dismissible alert-success">
      <strong>{{ alertMessage }}</strong>
    </div>
    <h1>{{ ProfileClass.userName }}</h1>
    <div class="container">
      <h3>Blood Organization Number : {{ ProfileClass.userNumber }}</h3>
      <h3>Blood Organization Email : {{ ProfileClass.userEmail }}</h3>
      <h3>Blood Organization Division : {{ ProfileClass.userDivision }}</h3>
      <h3>Blood Organization Distric : {{ ProfileClass.userDistric }}</h3>
      <h3>Blood Organization Upazila : {{ ProfileClass.userUpazila }}</h3>
      <button type="button" class="btn btn-danger" @click="deleteAccount()">
        Delete Account
      </button>
    </div>
  </div>
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "bloodOrgProfile",
  data() {
    return {
      ProfileClass: {
        userName: "",
        userNumber: "",
        userEmail: "",
        userDivision: "",
        userDistric: "",
        userUpazila: "",
      },
      showAlert: "",
      alertMessage: "",
    };
  },
  created() {
    this.fetchProfile();
  },
  methods: {
    async fetchProfile() {
      try {
        const response = await backendRestApi.bloodOrgProfilePage();
        this.ProfileClass = response.data;
      } catch (error) {
        console.error(error);
        this.showAlert = true;
        this.alertMessage = "Failed to fetch profile data.";
      }
    },
    async deleteAccount() {
      backendRestApi.deleteAccount().then((response) => {
        this.showAlert = true;
        this.alertMessage = response.data;
        setTimeout(() => {
          localStorage.removeItem("token");
          localStorage.clear();
          this.$router.push("/blood-org-login"); // Redirect to the dashboard page
        }, 3000);
      });
    },
  },
};
</script>

<style></style>

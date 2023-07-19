<template>
  <div>
    <h1>Search Blood</h1>
    <div class="container text-center mt-5">
      <!-- Search form -->
      <div class="row">
        <div class="col">
          <select
            class="form-select"
            aria-label="Default select example"
            v-model="searchOption"
          >
            <option selected>Search By</option>
            <option value="division">Division</option>
            <option value="distric">Distric</option>
            <option value="upazila">Upazila</option>
            <option value="bloodType">Blood Group</option>
          </select>
        </div>
        <div class="col">
          <input
            type="text"
            class="form-control"
            placeholder="Enter Blood type or Division or District or Upazila"
            aria-label="search"
            v-model="searchValue"
          />
        </div>
        <div class="col">
          <button
            type="button"
            @click="searchOrg(searchOption, searchValue)"
            class="btn btn-success"
          >
            Search
          </button>
        </div>
      </div>

      <div class="row">
        <div
          class="col"
          v-for="organizations in bloodOrg"
          :key="organizations.BloodOrganizationClass.bloodOrganizationId"
        >
          <div
            class="card text-white bg-success mt-5 mb-3"
            style="max-width: 20rem"
          >
            <div class="card-header">
              {{ organizations.BloodOrganizationClass.bloodOrganizationName }}
            </div>
            <div class="card-body">
              <h5 class="card-title">
                {{ organizations.BloodOrganizationClass.bloods }}
              </h5>
              <p class="card-text">
                {{
                  organizations.BloodOrganizationClass.bloodOrganizationEmail
                }}
              </p>
              <p class="card-text">
                {{
                  organizations.BloodOrganizationClass.bloodOrganizationDivision
                }}
              </p>
              <p class="card-text">
                {{
                  organizations.BloodOrganizationClass.bloodOrganizationDistric
                }}
              </p>
              <p class="card-text">
                {{
                  organizations.BloodOrganizationClass.bloodOrganizationUpozila
                }}
              </p>

              <button
                @click="
                  goTobloodRequest(
                    organizations.BloodOrganizationClass.bloodOrganizationName,
                    organizations.BloodOrganizationClass.bloodOrganizationEmail,
                    organizations.BloodOrganizationClass.bloods
                  )
                "
                class="btn btn-success"
                type="button"
              >
                Send Request
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Remove the container if you want to extend the Footer to full width. -->
</template>

<script>
import backendRestApi from "@/service/backendRestApi";
export default {
  name: "searchBlood",
  data() {
    return {
      searchValue: "",
      searchOption: "",
      bloodOrg: [],
    };
  },
  methods: {
    searchOrg(searchOption, searchValue) {
      switch (searchOption) {
        case "division":
          this.searchByDivision(searchValue);
          break;
        case "distric":
          this.searchByDistric(searchValue);
          break;
        case "upazila":
          this.searchByUpazila(searchValue);
          break;
        case "bloodType":
          this.searchByBloodType(searchValue);
          break;
      }
    },
    async searchByDivision(searchValue) {
      try {
        const response = await backendRestApi.searchBloodByDivision(
          searchValue
        );
        this.bloodOrg = response.data.map((organizations) => ({
          BloodOrganizationClass: {
            bloodOrganizationId: organizations.bloodOrganizationId || "",
            bloodOrganizationName: organizations.bloodOrganizationName || "",
            bloodOrganizationEmail: organizations.bloodOrganizationEmail || "",
            bloodOrganizationDivision:
              organizations.bloodOrganizationDivision || "",
            bloodOrganizationDistric:
              organizations.bloodOrganizationDistric || "",
            bloodOrganizationUpozila:
              organizations.bloodOrganizationUpozila || "",
            bloods: organizations.bloods || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
    async searchByDistric(searchValue) {
      try {
        const response = await backendRestApi.searchBloodByDistric(searchValue);
        this.bloodOrg = response.data.map((organizations) => ({
          BloodOrganizationClass: {
            bloodOrganizationId: organizations.bloodOrganizationId || "",
            bloodOrganizationName: organizations.bloodOrganizationName || "",
            bloodOrganizationEmail: organizations.bloodOrganizationEmail || "",
            bloodOrganizationDivision:
              organizations.bloodOrganizationDivision || "",
            bloodOrganizationDistric:
              organizations.bloodOrganizationDistric || "",
            bloodOrganizationUpozila:
              organizations.bloodOrganizationUpozila || "",
            bloods: organizations.bloods || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
    async searchByUpazila(searchValue) {
      try {
        const response = await backendRestApi.searchBloodByUpazila(searchValue);
        this.bloodOrg = response.data.map((organizations) => ({
          BloodOrganizationClass: {
            bloodOrganizationId: organizations.bloodOrganizationId || "",
            bloodOrganizationName: organizations.bloodOrganizationName || "",
            bloodOrganizationEmail: organizations.bloodOrganizationEmail || "",
            bloodOrganizationDivision:
              organizations.bloodOrganizationDivision || "",
            bloodOrganizationDistric:
              organizations.bloodOrganizationDistric || "",
            bloodOrganizationUpozila:
              organizations.bloodOrganizationUpozila || "",
            bloods: organizations.bloods || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
    async searchByBloodType(searchValue) {
      try {
        const response = await backendRestApi.searchBloodByBloodType(
          searchValue
        );
        this.bloodOrg = response.data.map((organizations) => ({
          BloodOrganizationClass: {
            bloodOrganizationId: organizations.bloodOrganizationId || "",
            bloodOrganizationName: organizations.bloodOrganizationName || "",
            bloodOrganizationEmail: organizations.bloodOrganizationEmail || "",
            bloodOrganizationDivision:
              organizations.bloodOrganizationDivision || "",
            bloodOrganizationDistric:
              organizations.bloodOrganizationDistric || "",
            bloodOrganizationUpozila:
              organizations.bloodOrganizationUpozila || "",
            bloods: organizations.bloods || "",
          },
        }));
      } catch (error) {
        console.log(error);
      }
    },
    goTobloodRequest(bloodOrgName, bloodOrganizationEmail, bloodGroup) {
      this.$router.push({
        name: "bloodRequest",
        params: {
          orgName: bloodOrgName,
          orgEmail: bloodOrganizationEmail,
          bloodType: bloodGroup,
        },
      });
    },
  },
};
</script>

<style></style>

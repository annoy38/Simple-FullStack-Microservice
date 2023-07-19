<template>
  <div>
    <h1>Search Eye Bank</h1>
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
          </select>
        </div>
        <div class="col">
          <input
            type="text"
            class="form-control"
            placeholder="Enter Division or District or Upazila Name"
            aria-label="search"
            v-model="searchValue"
          />
        </div>
        <div class="col">
          <button
            type="button"
            @click="searchEyeOrg(searchOption, searchValue)"
            class="btn btn-success"
          >
            Search
          </button>
        </div>
      </div>

      <div class="row">
        <div
          class="col"
          v-for="organizations in eyeOrg"
          :key="organizations.EyeOrganizationClass.eyeOrgId"
        >
          <div
            class="card text-white bg-success mt-5 mb-3"
            style="max-width: 20rem"
          >
            <div class="card-header">
              {{ organizations.EyeOrganizationClass.eyeOrgName }}
            </div>
            <div class="card-body">
              <p class="card-text">
                {{ organizations.EyeOrganizationClass.eyeOrgEmail }}
              </p>
              <p class="card-text">
                {{ organizations.EyeOrganizationClass.eyeOrgDivision }}
              </p>
              <p class="card-text">
                {{ organizations.EyeOrganizationClass.eyeOrgDistric }}
              </p>
              <p class="card-text">
                {{ organizations.EyeOrganizationClass.eyeOrgUpazila }}
              </p>

              <button
                @click="
                  goToEyeRequest(
                    organizations.EyeOrganizationClass.eyeOrgName,
                    organizations.EyeOrganizationClass.eyeOrgEmail
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

    <footer class="footer bg-success py-4">
      <div class="container text-center">
        <span class="text-muted">This is the footer content.</span>
      </div>
    </footer>
  </div>
</template>

<script>
import backendEyeRestApi from "@/service/backendEyeRestApi";
export default {
  name: "eyeSearch",
  data() {
    return {
      searchValue: "",
      searchOption: "",
      eyeOrg: [],
    };
  },
  created() {
    this.fetchAllEyeOrg();
  },
  methods: {
    async fetchAllEyeOrg() {
      try {
        const response = await backendEyeRestApi.allEyeOrg();
        this.eyeOrg = response.data.map((organizations) => ({
          EyeOrganizationClass: {
            eyeOrgId: organizations.eyeOrgId || "",
            eyeOrgName: organizations.eyeOrgName || "",
            eyeOrgEmail: organizations.eyeOrgEmail || "",
            eyeOrgDivision: organizations.eyeOrgDivision || "",
            eyeOrgDistric: organizations.eyeOrgDistric || "",
            eyeOrgUpazila: organizations.eyeOrgUpazila || "",
          },
        }));
      } catch (error) {
        console.error(error);
      }
    },

    searchEyeOrg(searchOption, searchValue) {
      switch (searchOption) {
        case "division":
          this.searchEyeByDivision(searchValue);
          break;
        case "distric":
          this.searchEyeByDistric(searchValue);
          break;
        case "upazila":
          this.searchEyeByUpazila(searchValue);
          break;
      }
    },

    async searchEyeByDivision(searchValue) {
      try {
        const response = await backendEyeRestApi.searchEyeOrgByDivision(
          searchValue
        );
        this.eyeOrg = response.data.map((organizations) => ({
          EyeOrganizationClass: {
            eyeOrgId: organizations.eyeOrgId || "",
            eyeOrgName: organizations.eyeOrgName || "",
            eyeOrgEmail: organizations.eyeOrgEmail || "",
            eyeOrgDivision: organizations.eyeOrgDivision || "",
            eyeOrgDistric: organizations.eyeOrgDistric || "",
            eyeOrgUpazila: organizations.eyeOrgUpazila || "",
          },
        }));
      } catch (error) {
        console.error(error);
      }
    },

    async searchEyeByDistric(searchValue) {
      try {
        const response = await backendEyeRestApi.searchEyeOrgByDistric(
          searchValue
        );
        this.eyeOrg = response.data.map((organizations) => ({
          EyeOrganizationClass: {
            eyeOrgId: organizations.eyeOrgId || "",
            eyeOrgName: organizations.eyeOrgName || "",
            eyeOrgEmail: organizations.eyeOrgEmail || "",
            eyeOrgDivision: organizations.eyeOrgDivision || "",
            eyeOrgDistric: organizations.eyeOrgDistric || "",
            eyeOrgUpazila: organizations.eyeOrgUpazila || "",
          },
        }));
      } catch (error) {
        console.error(error);
      }
    },

    async searchEyeByUpazila(searchValue) {
      try {
        const response = await backendEyeRestApi.searchEyeOrgByUpazila(
          searchValue
        );
        this.eyeOrg = response.data.map((organizations) => ({
          EyeOrganizationClass: {
            eyeOrgId: organizations.eyeOrgId || "",
            eyeOrgName: organizations.eyeOrgName || "",
            eyeOrgEmail: organizations.eyeOrgEmail || "",
            eyeOrgDivision: organizations.eyeOrgDivision || "",
            eyeOrgDistric: organizations.eyeOrgDistric || "",
            eyeOrgUpazila: organizations.eyeOrgUpazila || "",
          },
        }));
      } catch (error) {
        console.error(error);
      }
    },

    goToEyeRequest(eyeOrgName, eyeOrgEmail) {
      this.$router.push({
        name: "sendEyeRequest",
        params: {
          orgName: eyeOrgName,
          orgEmail: eyeOrgEmail,
        },
      });
    },
  },
};
</script>

<style></style>

<template>
  <nav class="navbar navbar-expand-lg bg-success" data-bs-theme="dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand mx-auto fs-2 fw-bold"
        >Blood And Eye Donation Bank</router-link
      >
    </div>
  </nav>
  <nav class="navbar navbar-expand-md bg-success" data-bs-theme="dark">
    <div class="container-fluid">
      <!-- <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button> -->
      <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item">
            <div class="ml-auto">
              <router-link to="/" class="nav-link bg-success text-white"
                >Blood Bank</router-link
              >
            </div>
          </li>
          <li class="nav-item">
            <div class="mr-auto">
              <router-link to="/eye-bank" class="nav-link bg-success mr-auto text-white"
                >Eye Bank</router-link
              >
            </div>
          </li>
          <li class="nav-item">
            <div class="mr-auto">
              <router-link to="/chatbot" class="nav-link bg-success mr-auto text-white"
                >ChatBot</router-link
              >
            </div>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <router-view></router-view>
  <!-- <footer class="footer bg-success py-4">
        <div class="container text-center">
          <span class="text-muted">This is the footer content.</span>
        </div>
      </footer> -->
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.navbar {
  height: 80px; /* Adjust the height as desired */
}

/* nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
} */
</style>

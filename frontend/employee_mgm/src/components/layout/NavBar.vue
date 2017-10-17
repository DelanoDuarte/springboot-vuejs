<template>
    <div class="navbarcomponent">
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <router-link to="/" class="navbar-brand">Emplyee Management App</router-link>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <router-link to="/cargo/all" class="nav-link">Cargo</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/funcionario/all" class="nav-link">Funcionários</router-link>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</template>

<script>
export default {
    name: 'navbarcomponent',

    data() {
        return {

            components: {

            },
            created: {

            },
            methods: {

            }
        }
    }
}
</script>

<style scoped>

</style>

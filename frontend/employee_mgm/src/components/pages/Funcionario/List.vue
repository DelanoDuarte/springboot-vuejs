<template>
    <div class="funcionariolist">

        <div class="col-md-12">
            <div align="center">
                <div class="col-md-12 animated fadeIn" align="center">
                    <div class="jumbotron">
                        <h3 class="display-4">Funcionários Cadastrados</h3>
                        <p class="lead">Lista de Funcionarios Cadastrados.</p>
                        <hr class="my-1">
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div class="row">
                    <table class="table table-hover table-striped">
                        <thead class="thead-inverse">
                            <tr>
                                <th>Código</th>
                                <th>Nome Funcionario</th>
                                <th>Data de Nascimento</th>
                                <th>Cargo</th>
                                <th>Setor</th>
                                <th>Ativo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="funcionario in funcionarios" v-bind:key="funcionario.idFuncinario">
                                <td>{{funcionario.idFuncinario}}</td>
                                <td>{{funcionario.nomeFuncionario}}</td>
                                <td>{{funcionario.dataNascimento}}</td>
                                <td>{{funcionario.funcionarioCargo.dscCargo}}</td>
                                <td>{{funcionario.funcionarioCargo.cargoSetor.dscSetor}}</td>
                                <td>
                                    <span class="badge badge-success" v-if="funcionario.funciarioAtivo">Sim</span>
                                    <span class="badge badge-warning" v-else>Não</span>
                                    <!--{{funcionario.funciarioAtivo}}-->
                                </td>
                                <td>
                                    <a class="btn btn-primary btn-sm text-white"> Show </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <br />
            <router-link class="btn btn-success" to="/funcionario/new">Novo Funcionario</router-link>

        </div>

    </div>
</template>
<script>
export default {
    name: 'funcionariolist',

    data() {
        return {

            funcionarios: []

        }
    },

    created() {

    },

    mounted() {
        this.getFuncionarios();
    },

    methods: {

        getFuncionarios() {
            fetch('http://localhost:8080/employee-management/funcionario/all')
                .then(response => {
                    response.json()
                        .then(data => {
                            this.funcionarios = data
                        })
                        .catch(error => {
                            console.log(error);
                        })
                })
                .catch(error => {
                    console.log(error);
                })
        }

    }
}
</script>
<style scoped>

</style>

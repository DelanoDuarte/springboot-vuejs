import Home from './components/pages/Home/Home';

import CargoList from './components/pages/Cargo/CargoList';
import CargoSave from './components/pages/Cargo/CargoSave';

import List from './components/pages/Funcionario/List'
import New from './components/pages/Funcionario/New'
import View from './components/pages/Funcionario/View'

export const approutes = [
    {
        path: '/',
        component: Home

    },
    {
        path: '/cargo/all',
        component: CargoList
    },
    {
        path: '/cargo/new',
        component: CargoSave
    },

    {
        path: '/funcionario/all',
        component: List
    },

    {
        path: '/funcionario/new',
        component: New
    },
    {
        path: '/funcionario/details/:funcionarioId',
        component: View,
        name: 'funcionario-details'
    }

]
import {makeStyles} from "@material-ui/core";

export const useStylesSignIn = makeStyles((theme) => ({
    wrapper: {
        display: 'flex',
        height: '100vh'
    },
    leftSide: {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flex: "0 0 50%",
        backgroundColor: '#71C9F8',
        overflow: 'hidden',
        position: 'relative'
    },
    leftSideListInfo: {
        position: 'relative',
        listStyle: 'none',
        padding: 0,
        margin: 0,
        width: 380,
        '& h6': {
            display: 'flex',
            alignItems: 'center',
            color: 'white',
            fontWeight: 700,
            fontSize: 20
        }
    },
    leftSideListInfoItem: {
        marginBottom: 40
    },
    leftSideIcon: {
        fontSize: 32,
        marginRight: 15
    },
    leftSideTwitterIcon: {
        position: 'absolute',
        left: '50%',
        top: '53%',
        transform: 'translate(-50%, -50%)',
        width: '350%',
        height: '350%',
    },
    rightSide: {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flex: '0 0 50%',
    },
    rightSideWrapper: {
        width: 380
    },
    rightSideTwitterIcon: {
        fontSize: 45
    },
    rightSideTittle: {
        fontWeight: 700,
        fontSize: 32,
        marginBottom: 45,
        marginTop: 20
    },
    loginSideField: {
        marginBottom: 18,
    },
    registerField: {
        marginBottom: theme.spacing(5),
    },
    loginFormControl: {
        marginBottom: theme.spacing(2),
    }
}));
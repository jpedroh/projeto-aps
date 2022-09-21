import { NextPage } from "next";
import Head from "next/head";
import Script from "next/script";

const Login: NextPage = () => {
  return <div className="flex flex-col gap-2 items-center justify-center min-h-screen">
    <Head>
      <meta name="google-signin-client_id"
        content="944589373335-dcoui95329jpdq66kpuk9jc2u2vbfpu9.apps.googleusercontent.com" />
    </Head>
    <div className="bg-blue-400 gap-2 px-6 py-10 flex items-center flex-col rounded-lg">
      <h1 className="font-bold text-xl">Realize o Login</h1>
      <button>Sign in with Google</button>
      <div className="g-signin2" data-onsuccess="onSignIn"></div>

      <form id="login" action="/api/login" method="POST">
        <input hidden id="id_token" type="text" name="id_token" />
      </form>

    </div>
    <Script src="https://apis.google.com/js/platform.js" async defer />
    <Script id="onSignIn">
      {`function onSignIn(googleUser) {
      var profile = googleUser.getBasicProfile();
      document.getElementById('id_token').setAttribute('value', googleUser.getAuthResponse().id_token)
      document.getElementById('login').submit();
}`}
    </Script>
  </div>;
}

export default Login;
import { NextPage } from "next";

const Login: NextPage = () => {
  return <div className="flex flex-col gap-2 items-center justify-center min-h-screen">
    <div className="bg-blue-400 gap-2 px-6 py-10 flex items-center flex-col rounded-lg">
      <h1 className="font-bold text-xl">Realize o Login</h1>
      <button>Sign in with Google</button>
    </div>
  </div>;
}

export default Login;
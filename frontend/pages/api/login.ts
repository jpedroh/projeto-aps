// Next.js API route support: https://nextjs.org/docs/api-routes/introduction
import type { NextApiRequest, NextApiResponse } from 'next'
import axios from 'axios';
import { serialize } from 'cookie';

type LoginResponse = {
  email: { valor: string }
  nome: string
}

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const { data } = await axios.post<LoginResponse>(`http://localhost:3000/login?id_token=${req.body.id_token}`)
  res.setHeader('Set-Cookie', serialize('email', data.email.valor, { path: '/', httpOnly: true, sameSite: 'lax' }));

  res.status(200).redirect('/')
}

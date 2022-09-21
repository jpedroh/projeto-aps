import { useQuery } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";

export function useUserHome() {
  return useQuery(['users', 'me', 'home'], () => {
    return axios.get('http://localhost:5001/pessoas/me/casa', {
      withCredentials: true
    }).then(r => r.data).catch((e: AxiosError) => {
      if (e.request?.status === 404) {
        return null;
      }
      throw e
    })
  }, {
  })
}
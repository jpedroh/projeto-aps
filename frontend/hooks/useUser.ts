import { useQuery } from "@tanstack/react-query"
import axios from "axios"

export function useUser() {
  return useQuery(['users', 'me'], () => {
    return axios.get('http://localhost:3001/users/me', {
      withCredentials: true
    }).then(r => r.data)
  })
}
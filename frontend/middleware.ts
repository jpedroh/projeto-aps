import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export function middleware(request: NextRequest) {
  const hasToken = request.cookies.has('email');

  if (request.nextUrl.pathname === 'login') {
    return NextResponse.next();
  }

  if (!hasToken) {
    return NextResponse.redirect(new URL("/login", request.url));
  }

  return NextResponse.next();
}

export const config = {
  matcher: '/:path*',
}

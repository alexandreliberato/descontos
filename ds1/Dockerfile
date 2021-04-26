FROM golang:1.16 as build-env
WORKDIR /go/src/app/pkg
ADD . /go/src/app
RUN go get -d -v ./...
RUN GOOS=linux GOARCH=amd64 go test && go build -ldflags="-w -s" -o /go/bin/app /go/src/app/pkg/app/server.go

FROM gcr.io/distroless/base
EXPOSE 9000
COPY --from=build-env /go/bin/app /
ENTRYPOINT ["/app"]

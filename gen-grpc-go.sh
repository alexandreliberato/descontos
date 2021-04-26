pwd
protoc --go_out=ds1/pkg --go_opt=paths=source_relative \
    --go-grpc_out=ds1/pkg --go-grpc_opt=paths=source_relative \
    discount.proto

// Licensed to the Apache Software Foundation (ASF) under one or more
// contributor license agreements.  See the NOTICE file distributed with
// this work for additional information regarding copyright ownership.
// The ASF licenses this file to You under the Apache License, Version 2.0
// (the "License"); you may not use this file except in compliance with
// the License.  You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package service

import (
	"context"
	"github.com/apache/incubator-eventmesh/eventmesh-server-go/config"
	"github.com/apache/incubator-eventmesh/eventmesh-server-go/log"
	"github.com/apache/incubator-eventmesh/eventmesh-server-go/runtime/proto/pb"
	"github.com/panjf2000/ants/v2"
)

type Producer struct {
	pb.UnimplementedPublisherServiceServer
	gctx     *GRPCContext
	sendPool *ants.Pool
}

func NewProducerServiceServer(gctx *GRPCContext) (*Producer, error) {
	ps := config.GlobalConfig().Server.GRPCOption.SendPoolSize
	pl, err := ants.NewPool(ps)
	if err != nil {
		return nil, err
	}
	return &Producer{
		gctx:     gctx,
		sendPool: pl,
	}, nil
}

func (p *Producer) Publish(ctx context.Context, msg *pb.SimpleMessage) (*pb.Response, error) {
	ctx = context.WithValue(ctx, "UNIQID", msg.UniqueId)
	log.Infof("cmd:%v, protocol:grpc, from:%v", "AsyncPublish", msg.Header.Ip)
	return nil, nil
}

func (p *Producer) RequestReply(ctx context.Context, msg *pb.SimpleMessage) (*pb.SimpleMessage, error) {
	return nil, nil
}

func (p *Producer) BatchPublish(ctx context.Context, msg *pb.BatchMessage) (*pb.Response, error) {
	return nil, nil
}
